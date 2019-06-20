package com.hellokoding.springboot.bean;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParameterService implements ParameterRepository {
    @Override
    public <S extends OrderParams> S save(S s) {
        return null;
    }

    @Override
    public <S extends OrderParams> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<OrderParams> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<OrderParams> findAll() {
        return null;
    }

    @Override
    public Iterable<OrderParams> findAllById(Iterable<Long> iterable) {
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
    public void delete(OrderParams orderParams) {
    }

    @Override
    public void deleteAll(Iterable<? extends OrderParams> iterable) {
    }

    @Override
    public void deleteAll() {
    }
}
