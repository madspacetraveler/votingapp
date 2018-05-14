package pl.votingapp.bo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.votingapp.dto.AccountDto;
import pl.votingapp.entity.Account;
import pl.votingapp.repository.AccountRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AccountService {
    public final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

        public List<AccountDto> findAccounts(){
            return accountRepository.findAll()
                    .stream()
                    .map(this::mapAccount)
                    .collect(Collectors.toList());
        }

    private AccountDto mapAccount(Account account) {
        return AccountDto.builder()
                .id(account.getId())
                .username(account.getName())
                .role(account.getRank())
                .email(account.getEmail())
                .active(account.isActive())
                .build();
    }

    public Long countAccounts(){
            return accountRepository.count();
    }

    public AccountDto addAccount(AccountDto accountDto){
        Account account = mapToAccount(accountDto);
        account = accountRepository.save(account);
        return mapAccount(account);
    }

    private Account mapToAccount(AccountDto accountDto) {
        return Account.builder()
                .id(accountDto.getId())
                .name(accountDto.getUsername())
                .rank(accountDto.getRole())
                .email(accountDto.getEmail())
                .active(accountDto.isActive())
                .password(passwordEncoder.encode(accountDto.getPassword()))
                .build();
    }

    public void deleteAccount(Long id){
        accountRepository.delete(id);
    }
}

