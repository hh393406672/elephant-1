package com.sjhy.platform.biz.test;

import com.sjhy.platform.client.dto.test.Person;
import com.sjhy.platform.persist.mysql.test.PersonMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 万二(Zheng Liu)
 */
@Service
public class PersonBO {

    @Resource
    private PersonMapper personMapper;

    public String test() {
        return "test";
    }

    public Integer countPerson() {
        return personMapper.countPerson();
    }

    public Person get(Long personId) {

        return personMapper.get(personId);
    }
}