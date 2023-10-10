package com.example.memberboard.entity;

import com.example.memberboard.dto.MemberDTO;
import com.example.memberboard.util.UtilClass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@Table(name = "member_table")
public class MemberEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false, unique = true)
    private String memberEmail;

    @Column(length = 20, nullable = false)
    private String memberPassword;

    @Column(length = 10, nullable = false)
    private String memberName;

    @Column(length = 10, nullable = false)
    private String memberMobile;

    @Column(length = 15, nullable = false)
    private String memberBirth;

    @Column(length = 255, nullable = true)
    private String originalFileName;

    @Column(length = 255, nullable = true)
    private String storedFileName;

    public static MemberEntity toMemberEntity(MemberDTO memberDTO){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberName(memberDTO.getMemberName());
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberPassword(memberDTO.getMemberPassword());
        memberEntity.setMemberBirth(memberDTO.getMemberBirth());
        return memberEntity;
    }

    public static MemberEntity toMemberPlusFileEntity(MemberDTO memberDTO){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberName(memberDTO.getMemberName());
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberPassword(memberDTO.getMemberPassword());
        memberEntity.setMemberBirth(memberDTO.getMemberBirth());
        memberEntity.setOriginalFileName(memberDTO.getOriginalFileName());
        memberEntity.setStoredFileName(memberDTO.getStoredFileName());
        return memberEntity;
    }




}
