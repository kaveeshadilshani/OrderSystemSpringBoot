package com.dfn.oms.newgen.testClientUI.bean;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JMSService implements JMSRepository{
    @Override
    public <S extends JMS> S save(S s) {
        return null;
    }

    @Override
    public <S extends JMS> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<JMS> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<JMS> findAll() {
        return null;
    }

    @Override
    public Iterable<JMS> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {
    }

    @Override
    public void delete(JMS jms) {
    }

    @Override
    public void deleteAll(Iterable<? extends JMS> iterable) {
    }

    @Override
    public void deleteAll() {
    }
}
