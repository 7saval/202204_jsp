package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import dto.Air;

public class AirDAO {
//	private String issueDate;
//	private String year = issueDate.substring(0, 4);
	public List<Map<String, Object>> selectList(String districtName){
		try(SqlSession session = MBConn.getSession()){
			return session.selectList("AirMapper.selectList", districtName);
		}
	}
	public int insert(List<Map<String, Object>> airlist){
		int cnt=0;
		try(SqlSession session = MBConn.getSession()){
			for(Map<String, Object> amap:airlist) {
				//한건 조회
				Air air = session.selectOne("AirMapper.selectOne", amap.get("sn"));
				//만약 데이터가 존재한다면 update
				if(air!=null)
					cnt += session.update("AirMapper.update", amap);
				else
					//존재하지 않는다면 insert
					cnt += session.insert("AirMapper.insert", amap);
			}
			//반복문 종료후 commit : mybatisConfig의 transactionManager JDBC
			session.commit();
			return cnt;
		}
		
	}
	public Air selectOne(int sn) {
		try(SqlSession session=MBConn.getSession()){
			return session.selectOne("AirMapper.selectOne", sn);
		}
	}
}
