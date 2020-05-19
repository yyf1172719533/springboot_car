package com.timain.web.bus.service.impl;

import com.timain.web.bus.mapper.CustomerMapper;
import com.timain.web.bus.pojo.Customer;
import com.timain.web.bus.service.CustomerService;
import com.timain.web.bus.vo.CustomerVO;
import com.timain.web.sys.common.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/5/19 10:44
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    
    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 条件分页查询客户信息
     * @param customerVO
     * @return
     */
    @Override
    public DataGridView findAllCustomers(CustomerVO customerVO) {
        PageRequest pageRequest = PageRequest.of(customerVO.getPage() - 1, customerVO.getLimit());
        Page<Customer> page = customerMapper.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();
            if (null!=customerVO.getCustomerName() && customerVO.getCustomerName()!="") {
                predicateList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.like(
                                        root.get("customerName"), "%" + customerVO.getCustomerName() + "%"
                                )
                        )
                );
            }
            if (null!=customerVO.getIdentity() && customerVO.getIdentity()!="") {
                predicateList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.like(
                                        root.get("identity"), "%" + customerVO.getIdentity() + "%"
                                )
                        )
                );
            }
            if (null!=customerVO.getAddress() && customerVO.getAddress()!="") {
                predicateList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.like(
                                        root.get("address"), "%" + customerVO.getAddress() + "%"
                                )
                        )
                );
            }
            if (null!=customerVO.getPhone() && customerVO.getPhone()!="") {
                predicateList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.like(
                                        root.get("phone"), "%" + customerVO.getPhone() + "%"
                                )
                        )
                );
            }
            if (null!=customerVO.getCareer() && customerVO.getCareer()!="") {
                predicateList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.like(
                                        root.get("career"), "%" + customerVO.getCareer() + "%"
                                )
                        )
                );
            }
            if (null!=customerVO.getStartTime()) {
                predicateList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.greaterThanOrEqualTo(
                                        root.<Date>get("createTime"), customerVO.getStartTime()
                                )
                        )
                );
            }
            if (null!=customerVO.getEndTime()) {
                predicateList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.lessThanOrEqualTo(
                                        root.<Date>get("createTime"), customerVO.getEndTime()
                                )
                        )
                );
            }
            return criteriaBuilder.and(
                    predicateList.toArray(new Predicate[predicateList.size()])
            );
        }, pageRequest);
        return new DataGridView(page.getTotalElements(), page.getContent());
    }

    /**
     * 添加或修改客户信息
     *
     * @param customer
     */
    @Override
    public void addOrUpdateCustomer(Customer customer) {
        this.customerMapper.saveAndFlush(customer);
    }

    /**
     * 根据ID删除客户
     *
     * @param id
     */
    @Override
    public void deleteCustomer(Integer id) {
        this.customerMapper.deleteById(id);
    }
}
