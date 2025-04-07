package teamproject;

import java.util.ArrayList;

public class Service {
	ParentsDAO pdao = new ParentsDAO();
	StudentDAO stdao = new StudentDAO();
	NoticeDAO n_dao = new NoticeDAO();

	public void registerStudent(Student s) {
		stdao.insertMember(s);
	}

	public ArrayList<Student> getStudentList() {
		return stdao.selectAll();
	}

	public void deleteStudent(String student_cd) {
		stdao.delete(student_cd);
	}

	public void updateStudent(Student s) {
		stdao.update(s);
	}

	public Student selectOne(String student_cd) {
		return stdao.selectOne(student_cd);
	}

	public void updateStudentWithOriginalCd(Student s, String original_cd) {
		stdao.updateWithOriginalCd(s, original_cd);
	}

	
	
	public void registerParents(Parents p) {
		pdao.insertMember(p);
	}
	
	public ArrayList<Parents> getParentsList() {
		return pdao.selectAll();
	}

	public void deleteParents(String parent_id) {
		pdao.delete(parent_id);
	}
	
	public void updateParents(Parents p) {
		pdao.update(p);
	}

	public Parents selectOne1(String parent_id) {
		return pdao.selectOne(parent_id);
	}

	public void updateParentsWithOriginalCd(Parents p, String original_cd) {
		pdao.updateWithOriginalCd1(p, original_cd);
	}
	
	public void insertNotice(Notice notice) {
		n_dao.insert(notice);
	}
	
	public void updateNotice(Notice notice) {
		n_dao.update(notice);
	}
	
	public Notice selectOneNotice(String notices_cd) {
		
		Notice notice = n_dao.selectOne(notices_cd);
		
		return notice;
	}
	
	public ArrayList<Notice> selectNotice(String teacher_cd){
		return n_dao.selectAll(teacher_cd);
	}

	public void deleteNotice(String notices_cd) {
		n_dao.delete(notices_cd);
	}
}
