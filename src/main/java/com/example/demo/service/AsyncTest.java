package com.example.demo.service;

import com.example.demo.model.user.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class AsyncTest {

    @Autowired
    private final UserRepository userRepository;

    public AsyncTest(
            UserRepository userRepository
    ){
        this.userRepository = userRepository;
    }

    public static CompletableFuture<String> findName(String name, Long sleepTime) throws InterruptedException {
        System.out.println("Async function started. processName: " + name + "sleepTime: " + sleepTime);
        Thread.sleep(sleepTime);

        // 非同期処理のハンドリングができるようにCompletableFutureに実際に使いたい返却値をぶっこんで利用する
        return CompletableFuture.completedFuture(name);
    }

    public CompletableFuture<List<User>> getUser(String name) throws InterruptedException {
        List<User> userList = userRepository.findByUserNameLike(name);

        return CompletableFuture.completedFuture(userList);
    }

}
