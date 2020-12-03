package guru.springframework.springrestclientexamples.services;

import guru.springframework.api.domain.User;
import guru.springframework.api.domain.UserData;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class ApiServiceImpl implements  ApiService {

    //injecting the instance of RestTemplate
    private RestTemplate restTemplate;

    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<User> getUsers(Integer limit) {

        //get request
        //we're using the method getForObject and passing in a URL in production
        List<User> user = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users?limit=" + limit, List.class);
        return user;
    }
}
