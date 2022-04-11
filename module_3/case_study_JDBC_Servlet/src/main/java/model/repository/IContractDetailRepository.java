package model.repository;

import model.bean.Contract;
import model.bean.Contract_detail;

import java.sql.SQLException;
import java.util.List;

public interface IContractDetailRepository {
    public boolean insertContractDetail(Contract_detail contract_detail) throws SQLException;
    public List<Contract_detail> selectAllContractsDetail();
}
