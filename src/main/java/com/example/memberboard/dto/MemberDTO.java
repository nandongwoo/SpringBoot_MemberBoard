package com.example.memberboard.dto;

import com.example.memberboard.entity.MemberEntity;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MemberDTO {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
    private String memberMobile;
    private String memberBirth;
    private MultipartFile memberProfile;

    private String originalFileName;
    private String storedFileName;



    public static MemberDTO toMemberDTO(MemberEntity memberEntity){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setMemberBirth(memberEntity.getMemberBirth());
        memberDTO.setMemberPassword(memberEntity.getMemberPassword());
        memberDTO.setMemberEmail(memberEntity.getMemberEmail());
        memberDTO.setMemberMobile(memberEntity.getMemberMobile());
        memberDTO.setMemberName(memberEntity.getMemberName());
        if(memberEntity.getOriginalFileName()!=null){
            memberDTO.setOriginalFileName(memberEntity.getOriginalFileName());
            memberDTO.setStoredFileName(memberEntity.getStoredFileName());
        }
        return memberDTO;
    }
}
