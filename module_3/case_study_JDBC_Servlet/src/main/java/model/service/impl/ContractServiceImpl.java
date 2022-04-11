package model.service.impl;

import model.bean.Contract;
import model.repository.IContractRepository;
import model.repository.impl.ContractRepositoryImpl;
import model.service.IContractService;

import java.sql.SQLException;
import java.util.List;

public class ContractServiceImpl implements IContractService {
    IContractRepository contractRepository = new ContractRepositoryImpl();
    @Override
    public boolean insertContract(Contract contract) throws SQLException {
        return contractRepository.insertContract(contract);
    }

    @Override
    public boolean updateServiceForContract(int new_service_id, int c_id, int old_service_id) throws SQLException {
        return contractRepository.updateServiceForContract(new_service_id,c_id,old_service_id);
    }


    @Override
    public List<Contract> selectAllContracts() {
        return contractRepository.selectAllContracts();
    }
}
