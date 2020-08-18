package contract.service;

import contract.pojo.Htfl;
import contract.pojo.Users;
import contract.utils.ServerResponse;

import java.util.List;

public interface HtflService {
    ServerResponse<List<Htfl>> query();

    ServerResponse delete(Users users, int id);

    ServerResponse insert(Users users,Htfl htfl);
}
