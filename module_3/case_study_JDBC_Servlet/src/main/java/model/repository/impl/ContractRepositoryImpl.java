package model.repository.impl;

import model.bean.Contract;
import model.bean.Service;
import model.repository.BaseRepository;
import model.repository.IContractRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepositoryImpl implements IContractRepository {
    private static final String INSERT_IN_TO_CONTRACT = "insert into contract (contract_start_date , contract_end_date , contract_deposit ,contract_total_money ,employee_id  ,customer_id  ,service_id ) value\n" +
            "(?,?,?,?,?,?,?); ";
    private static final String UPDATE_SERVICE_FOR_CONTRACT="update contract set service_id=?  where customer_id=? and service_id=?; ";

    private static final String SELECT_ALL_CONTRACTS = "select * from contract ;";
    @Override
    public boolean insertContract(Contract contract) throws SQLException {
        boolean check =false;
        Connection connection = BaseRepository.getConnect();
        PreparedStatement preparedStatement =connection.prepareStatement(INSERT_IN_TO_CONTRACT);
        preparedStatement.setString(1, contract.getContract_start_date());
        preparedStatement.setString(2, contract.getContract_end_date());
        preparedStatement.setDouble(3,contract.getContract_deposit());
        preparedStatement.setDouble(4,contract.getContract_total_money());
        preparedStatement.setInt(5,contract.getEmployee_id());
        preparedStatement.setInt(6,contract.getCustomer_id());
        preparedStatement.setInt(7,contract.getService_id());

        check =preparedStatement.executeUpdate()>0;

        return check;
    }

    @Override
    public boolean updateServiceForContract(int new_service_id, int c_id, int old_service_id) throws SQLException {
        boolean check =false;
        Connection connection = BaseRepository.getConnect();
        PreparedStatement preparedStatement =connection.prepareStatement(UPDATE_SERVICE_FOR_CONTRACT);
        preparedStatement.setInt(1,new_service_id);
        preparedStatement.setInt(2,c_id);
        preparedStatement.setInt(3,old_service_id);
        check=preparedStatement.executeUpdate()>0;
        return check;
    }


    @Override
    public List<Contract> selectAllContracts() {
        List<Contract> contracts = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACTS);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("contract_id");
                String start_date= resultSet.getString("contract_start_date");
                String end_date= resultSet.getString("contract_end_date");

                double deposit= resultSet.getDouble("contract_deposit");
                double total_money= resultSet.getDouble("contract_total_money");
                int employee_id = resultSet.getInt("employee_id");
                int customer_id = resultSet.getInt("customer_id");
                int service_id =resultSet.getInt("service_id");
                contracts.add(new Contract(id,start_date,end_date,deposit,total_money,employee_id,customer_id,service_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contracts;
    }
}
