package model.repository;

import model.bean.Contract;
import model.bean.Service;

import java.sql.SQLException;
import java.util.List;

public interface IContractRepository {
    public boolean insertContract(Contract contract) throws SQLException;
    public boolean updateServiceForContract(int new_service_id, int c_id, int old_service_id) throws SQLException;
    public List<Contract> selectAllContracts();
}
