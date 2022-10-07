package com.runsystem.student.service.impl;

import com.runsystem.student.api.input.StudentInput;
import com.runsystem.student.converter.StudentInfoConverter;
import com.runsystem.student.converter.StudentInputConverter;
import com.runsystem.student.dto.StudentInfoDTO;
import com.runsystem.student.entity.ListStudentEntity;
import com.runsystem.student.entity.StudentEntity;
import com.runsystem.student.entity.StudentInfoEntity;
import com.runsystem.student.repository.StudentInfoRepository;
import com.runsystem.student.repository.StudentRepository;
import com.runsystem.student.service.IStudentInfoService;
import com.runsystem.student.utils.ConvertDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentInfoService implements IStudentInfoService {
    @Autowired
    StudentInfoRepository studentInfoRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    private StudentInfoConverter studentInfoConverter;

    @Autowired
    private StudentInputConverter studentInputConvert;

    ConvertDate convertDate;

    @Override
    public StudentInfoDTO saveStudentInfo(StudentInput studentInfoInput) {
//      Chuyển đổi dữ liệu từ StudentInput thành StudentEntity
        StudentEntity studentEntity = studentInputConvert.toStudentEntity(studentInfoInput);
        studentEntity = studentRepository.save(studentEntity);
        StudentInfoEntity studentInfoEntity = null;

        // Kiểm tra ID nếu không tồn tại thì thêm, ngược lại cập nhật
        if (studentInfoInput.getStudentId() == null) {

            // Chuyển data từ StuedentInput thành StudentInfoEntity
            studentInfoEntity = studentInputConvert.toStudentInfoEntity(studentInfoInput);
            studentInfoEntity.setStudent(studentEntity);
        } else {

            // Tìm kiếm StudentInfoEntity theo ID mới trả lại của sinh viên
            List<StudentInfoEntity> infoEntities = studentInfoRepository.findByStudent(studentEntity);

            // Chuyển đổi dữ liệu studentInput thành StudentInfoEntity
            studentInfoEntity = studentInputConvert.toStudentInfoEntity(studentInfoInput);
            studentInfoEntity.setInfoId(infoEntities.get(0).getInfoId());
        }

        // Cập nhật studentInfo và trả lại StudentInfo đã chỉnh sửa
        studentInfoEntity.setStudent(studentEntity);//lay lại studentId khi cap nhat
        StudentInfoEntity resultStudentInfoEntity = studentInfoRepository.save(studentInfoEntity);
        studentEntity = studentRepository.getOne(studentEntity.getStudentId());
        resultStudentInfoEntity.setStudent(studentEntity);
        return studentInfoConverter.toDTO(resultStudentInfoEntity);
    }

    @Override
    public List<StudentInfoDTO> searchStudentByInfo(StudentInput student) {

        List<StudentInfoDTO> lisDtos = new ArrayList<StudentInfoDTO>();

//      lưu kết quả sau khi lọc
        List<ListStudentEntity> studentInfoEntitiesByName = new ArrayList<ListStudentEntity>();

        // StringUtils.isNotBlank(student.getStudentName()) || StringUtils.isNotBlank(student.getStudentCode())

        if(student.getBirthDay() == null){
            studentInfoEntitiesByName = studentInfoRepository.searchListStudent(student.getStudentCode(), student.getStudentName(), null);
        }else{
//    	    Query data by studentName, studentCode, birthDay.
            studentInfoEntitiesByName = studentInfoRepository.searchListStudent(student.getStudentCode(), student.getStudentName(), convertDate.toLong(student.getBirthDay()));
        }

//      Chuyển đổi dữ liệu danh sách sang dto
        studentInfoEntitiesByName.forEach((n) -> {
            StudentInfoDTO itemDto = studentInfoConverter.toDTO(n);
            lisDtos.add(itemDto);
        });
        return lisDtos;
    }

    @Override
    public void deleteByStudentID(Long id) {
        studentRepository.deleteById(id);
        studentInfoRepository.deleteById(id);
    }

    @Override
    public List<StudentInfoDTO> getListStudent(){
        List<StudentInfoDTO> lisDtos = new ArrayList<StudentInfoDTO>();
        List<StudentInfoEntity> entities = studentInfoRepository.findAll();;
//        Chuyển đổi dữ liệu danh sách sang dto
        entities.forEach((n) -> {
            StudentInfoDTO itemDto = studentInfoConverter.toDTO(n);
            lisDtos.add(itemDto);
        });
        return lisDtos;
    }
}
