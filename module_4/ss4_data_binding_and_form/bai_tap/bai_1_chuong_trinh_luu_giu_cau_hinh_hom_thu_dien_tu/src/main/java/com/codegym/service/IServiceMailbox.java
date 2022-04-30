package com.codegym.service;

import com.codegym.entity.Mailbox;

import java.util.List;

public interface IServiceMailbox {
    List<Mailbox> findAll();
    void update(Mailbox mailbox);
}
