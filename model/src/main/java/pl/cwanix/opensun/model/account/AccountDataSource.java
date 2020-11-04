package pl.cwanix.opensun.model.account;

public interface AccountDataSource {

    UserModel findUser(String userName);
}
