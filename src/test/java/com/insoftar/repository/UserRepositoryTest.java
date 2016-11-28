package com.insoftar.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

import com.insoftar.domain.User;
import com.insoftar.util.Util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class UserRepositoryTest {

    private static final int CELLPHONE_LENGTH = 10;
    private static final int BEGIN_EMAIL_LENGTH = 31;
    private static final String END_EMAIL_STRING = "@appministrator.com";
    private static final int IDENTIFICATION_LENGTH = 20;
    private static final int NAME_OR_LASTNAME_LENGTH = 50;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private IUserRepository userRepository;

    @Test
    public void whenUserIsSavedThenReturnEntityWithId() {
        User newUser = createUser();

        assertThat(newUser.getId(), notNullValue());
    }

    @Test
    public void whenFindUserByIdThenReturnEntityWithSameId() {
        User newUser = createUser();

        User userFoundItById = userRepository.findOne(newUser.getId());

        assertThat(userFoundItById.getId(), equalTo(newUser.getId()));
    }

    @Test
    public void whenDeleteUserThenCannotFindIt() {
        User newUser = createUser();

        userRepository.delete(newUser.getId());
        User userDeleted = userRepository.findOne(newUser.getId());

        assertThat(userDeleted, nullValue());
    }

    @Test
    public void whenCreateFiveUsersThenRetrieveFiveUsers() {
        for (int i = 0; i < 5; i++) {
            createUser();
        }

        DataTablesOutput<User> output = userRepository.findAll(new DataTablesInput());

        assertThat(output.getRecordsTotal(), equalTo(5L));
    }

    private User createUser() {
        User user = new User();
        user.setCellphone(Util.generateRandomNumericString(CELLPHONE_LENGTH));
        user.setEmail(Util.generateRandomAlphanumericString(BEGIN_EMAIL_LENGTH) + END_EMAIL_STRING);
        user.setIdentification(Util.generateRandomNumericString(IDENTIFICATION_LENGTH));
        user.setLastName(Util.generateRandomAlphabeticString(NAME_OR_LASTNAME_LENGTH));
        user.setName(Util.generateRandomAlphabeticString(NAME_OR_LASTNAME_LENGTH));

        return entityManager.persist(user);
    }

}
