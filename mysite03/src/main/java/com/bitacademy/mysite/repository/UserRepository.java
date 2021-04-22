package com.bitacademy.mysite.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.mysite.exception.UserRepositoryException;
import com.bitacademy.mysite.vo.UserVo;

@Repository
public class UserRepository {
	@Autowired
	private SqlSession sqlSession;
	
	public UserVo findByNo(Long no) {
		return sqlSession.selectOne("user.find", no);
	}

	public UserVo findByEmailAndPassword(UserVo vo) throws UserRepositoryException {
		return sqlSession.selectOne("user.findByEmailAndPassword", vo);
	}
	
	public boolean insert(UserVo vo) {
		System.out.println(vo.getNo());
		int count = sqlSession.insert("user.insert", vo);
		System.out.println(vo.getNo());
		return count == 1;
	}

	public boolean update(UserVo vo) {
		int count = sqlSession.insert("user.update", vo);
		return count == 1;
	}
}
