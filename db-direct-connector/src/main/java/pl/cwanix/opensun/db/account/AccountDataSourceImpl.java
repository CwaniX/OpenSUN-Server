package pl.cwanix.opensun.db.account;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.cwanix.opensun.db.account.entity.UserEntity;
import pl.cwanix.opensun.db.account.repository.UserEntityRepository;
import pl.cwanix.opensun.model.account.AccountDataSource;
import pl.cwanix.opensun.model.account.UserModel;

@Service
@RequiredArgsConstructor
public class AccountDataSourceImpl implements AccountDataSource {

    private final ModelMapper modelMapper;
    private final UserEntityRepository userEntityRepository;

    @Override
    public UserModel findUser(final String name) {
        final UserEntity entity = userEntityRepository.findByName(name);

        return modelMapper.map(entity, UserModel.class);
    }
}
