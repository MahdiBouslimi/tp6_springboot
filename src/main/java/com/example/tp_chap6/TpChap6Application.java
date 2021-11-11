package com.example.tp_chap6;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TpChap6Application {

    public static void main(String[] args) {

        SpringApplication.run(TpChap6Application.class, args);
    }
    @Bean
    public CommandLineRunner demo(UserRep userRep, LogsRep logsRep, GroupRep groupRep) {
        return (args) -> {
            // save a New Users

            User u1= new User(1, "Chloe", "O'Brian", new ArrayList<Logs>(), new ArrayList<Group>());
            User u2= new User(2, "Kim", "Bauer", new ArrayList<Logs>(), new ArrayList<Group>());
            User u3 = new User(3, "David", "Palmer", new ArrayList<Logs>(), new ArrayList<Group>());


//            userRep.save(u1);
//            userRep.save(u2);
//            userRep.save(u3);

            List<User> user= new ArrayList<>();
            user.add(u1);
            user.add(u2);
            user.add(u3);
            userRep.saveAll(user);

            // save a New Logs

            Logs l1= new Logs( "2021-10-11", "this is first logs", u1);
            Logs l2= new Logs("2021-10-20", "this is thirs logs",u2);
            Logs l3=new Logs("2021-12-15", "this is fourth logs",u3);


            logsRep.save(l1);
            logsRep.save(l2);
            logsRep.save(l3);

            //liaison User_logs
            ArrayList<Logs> logs = new ArrayList<Logs>();
            logs.add(l1);
            logs.add(l2);
            logs.add(l3);

            u1.setLogs(logs);
            userRep.save(u1);




            // save a New Groups

            Group g1 = new Group(  "group1", "40", new ArrayList<User>());
            Group g2 = new Group("groupe2", "30", new ArrayList<User>() );

            groupRep.save(g1);
            groupRep.save(g2);


            //liaison User_group


            ArrayList<Group> groups =  new ArrayList();
            groups.add(g1);
            groups.add(g2);
            u1.setGroup(groups);
            userRep.save(u1);


            ArrayList<User> users = new ArrayList();
            users.add(u1);
            users.add(u2);
            g1.setUser(users);
            groupRep.save(g1);


        };

    }
    }


