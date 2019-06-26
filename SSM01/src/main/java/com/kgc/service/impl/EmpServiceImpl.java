package com.kgc.service.impl;

import com.kgc.mapper.Dept2Mapper;
import com.kgc.mapper.EmpMapper;
import com.kgc.pojo.Dept2;
import com.kgc.pojo.Emp;
import com.kgc.pojo.EmpExample;
import com.kgc.pojo.pageBean;
import com.kgc.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class EmpServiceImpl implements IEmpService {
    @Autowired
    private Dept2Mapper deptMapper;
    @Autowired
    private EmpMapper empMapper;


    @Override// 条件分页查询员工
    public List<Emp> show(pageBean page) {
        EmpExample e = new EmpExample();
        EmpExample.Criteria c = e.createCriteria();
        if(page.getName() != null){
            c.andNameLike("%" + page.getName() + "%");
        }
        if(page.getStartHiredate() != null){
            c.andHiredateGreaterThanOrEqualTo(page.getStartHiredate());
        }
        if(page.getEndHiredate() != null){
            c.andHiredateLessThanOrEqualTo(page.getEndHiredate());
        }
        if(page.getDeptno() != null && page.getDeptno() != 0){
            c.andDeptnoEqualTo(page.getDeptno());
        }
        //查询总记录数
        int count = (int) empMapper.countByExample(e);
        int size = page.getSize();
        int totalPage = (count % size == 0) ? (count / size) : (count / size + 1);
        page.setCount(count);
        page.setTotalPage(totalPage);
        // 分页
        int startRow = (page.getCurrPage() - 1) * size;
        e.limit(startRow,size);

        List<Emp> list = empMapper.selectByExample(e);
        for(Emp emp : list){
            Dept2 dept = deptMapper.selectByPrimaryKey(emp.getDeptno());
            emp.setDept2(dept);
        }
        return list;
    }

    @Override// 查询所有的部门
    public List<Dept2> selectDepts() {

        return deptMapper.selectByExample(null);
    }

    @Override
    public int deleteById(int number) {
        return empMapper.deleteByPrimaryKey(number);
    }

    @Override
    public int addEmp(Emp emp) {
        return empMapper.insertSelective(emp);
    }

    @Override
    public Emp selectById(int number) {
        return empMapper.selectByPrimaryKey(number);
    }

    @Override
    public int updateEmp(Emp emp) {
        return empMapper.updateByPrimaryKeySelective(emp);
    }

    @Override
    public void batDel(Integer[] ids) {
        //第一种方式
      /*  for(int id : ids){
            empMapper.deleteByPrimaryKey(id);
        }*/
        //第二种方式
        EmpExample e = new EmpExample();
        EmpExample.Criteria c = e.createCriteria();
        c.andNumberIn(Arrays.asList(ids));
        empMapper.deleteByExample(e);
    }
}

