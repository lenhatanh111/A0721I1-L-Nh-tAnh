package com.codegym.service;

import com.codegym.entity.Mailbox;

import java.util.ArrayList;
import java.util.List;

public class ServiceMailboxImpl implements IServiceMailbox{
    private static List<Mailbox> mailboxes=new ArrayList<>();
    static {
        mailboxes.add(new Mailbox("English","15",true,"anh"));
    }
    @Override
    public List<Mailbox> findAll() {
        return mailboxes;
    }

    @Override
    public void update(Mailbox mailbox) {
mailboxes.clear();
mailboxes.add(mailbox);
    }
}
