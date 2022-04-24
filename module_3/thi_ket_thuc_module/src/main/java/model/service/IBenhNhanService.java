package model.service;

import model.bean.BenhNhan;

import java.util.List;

public interface IBenhNhanService {
    public List<BenhNhan> findAll();
    public boolean edit(BenhNhan benhNhan);
    public boolean delete(String id);
    public BenhNhan findBenhNhanByID(String id);
}
