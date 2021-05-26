package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FileMapper {

    @Select("SELECT * FROM FILES WHERE userid = #{userid}")
    List<File> getFiles(Integer userId);

    @Insert("INSERT INTO FILES(filename, contenttype, filesize, userid) VALUES (#{filename}, #{contenttype}, #{filesize}, #{userid})")
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
    int insertFile(File file);
}
