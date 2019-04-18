package almeida.springframework.springrestclientexamples.services;

import almeida.springframework.api.domain.User;

import java.util.List;

public interface ApiService {

    List<User> getUsers(Integer limit);

}
