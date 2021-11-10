//package com.example.demo;
//
//import com.example.demo.Pojo.User;
//import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
//import org.springframework.stereotype.Repository;
//
//
////@Repository
//public interface UserRepository extends ReactiveMongoRepository<User,String> {
//
//}

package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


//@Repository
public interface UserRepository extends ReactiveMongoRepository<User,String> {

}
