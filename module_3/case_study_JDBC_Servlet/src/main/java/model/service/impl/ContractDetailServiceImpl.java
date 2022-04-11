package model.service.impl;

import model.bean.Contract_detail;
import model.repository.IContractDetailRepository;
import model.repository.impl.ContractDetailRepositoryImpl;
import model.service.IContractDetailService;
import model.service.IContractService;

import java.sql.SQLException;
import java.util.List;

public class ContractDetailServiceImpl implements IContractDetailService {
    IContractDetailRepository contractDetailRepository = new ContractDetailRepositoryImpl();
    @Override
    public boolean insertContractDetail(Contract_detail contract_detail) throws SQLException {
        return contractDetailRepository.insertContractDetail(contract_detail);
    }

    @Override
    public List<Contract_detail> selectAllContractsDetail() {
        return contractDetailRepository.selectAllContractsDetail();
    }
}
