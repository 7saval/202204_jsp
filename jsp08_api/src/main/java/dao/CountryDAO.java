package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import dto.Country;

public class CountryDAO {

	public List<Map<String, String>> selectList_iso() {
		try(SqlSession session = MBConn.getSession()){
			return session.selectList("CountryMapper.selectList_iso");
		}
		
	}

	public int insert(List<Map<String, String>> clist) {
		//파싱한 맵의 리스트 저장
		int cnt = 0;
		//try~with문 close자동
		try(SqlSession session = MBConn.getSession()){
			for(Map<String, String> cmap:clist) {
				//한건조회
				Country country = session.selectOne("CountryMapper.selectOne", cmap.get("sfty_notice_id"));
					//만약 데이터가 존재한다면 update
				if(country!=null)
					cnt += session.update("CountryMapper.update", cmap);
				else
					//존재하지 않는다면 insert
					cnt += session.insert("CountryMapper.insert", cmap);
			}
			//반복문 종료후 commit : mybatisConfig의 transactionManager JDBC
			session.commit();
			return cnt;
		}
	}
	public List<Country> selectList(String iso){
		try(SqlSession session=MBConn.getSession()){
			return session.selectList("CountryMapper.selectList", iso);
		}
	}
	public Country selectOne(String sfty_notice_id) {
		try(SqlSession session=MBConn.getSession()){
			return session.selectOne("CountryMapper.selectOne", sfty_notice_id);
		}
	}

	
}
