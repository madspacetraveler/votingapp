package pl.votingapp.bo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import pl.votingapp.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(MockitoJUnitRunner.class)
class UserServiceTest {

    @Mock
    UserRepository userRepositoryMock;

    @InjectMocks
    UserService userServiceImpl;

    @Test
    void findUser() {
    }

    @Test
    void countUsers() {
      //  when(userRepositoryMock.findAll()).getMock();
       // assertEquals(1, userServiceImpl.countUsers());
    }

    @Test
    void findUsers() {
    }

}