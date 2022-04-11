package model.repository.impl;

import model.bean.Contract;
import model.bean.Contract_detail;
import model.repository.BaseRepository;
import model.repository.IContractDetailRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailRepositoryImpl implements IContractDetailRepository {
    private static final String INSERT_IN_TO_CONTRACT_DETAIL = "insert into contract_detail (contract_id , attach_service_id ,quantity ) value\n" +
            "(?,?,?); ";

    private static final String SELECT_ALL_CONTRACT_DETAILS = "select * from contract_detail ;";
    @Override
    public boolean insertContractDetail(Contract_detail contract_detail) throws SQLException {
        boolean check =false;
        Connection connection = BaseRepository.getConnect();
        PreparedStatement preparedStatement =connection.prepareStatement(INSERT_IN_TO_CONTRACT_DETAIL);
        preparedStatement.setInt(1, contract_detail.getContract_id());
        preparedStatement.setInt(2, contract_detail.getAttach_service_id());
        preparedStatement.setInt(3,contract_detail.getQuantity());

        check =preparedStatement.executeUpdate()>0;

        return check;
    }

    @Override
    public List<Contract_detail> selectAllContractsDetail() {
        List<Contract_detail> contract_details = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT_DETAILS);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("contract_detail_id");
                int contract_id = resultSet.getInt("contract_id");
                int attach_service_id =resultSet.getInt("attach_service_id");
                int quantity = resultSet.getInt("quantity");
               contract_details.add(new Contract_detail(id,contract_id,attach_service_id,quantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contract_details;
    }
}
