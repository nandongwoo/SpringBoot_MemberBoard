package com.example.memberboard.service;

import com.example.memberboard.dto.MemberDTO;
import com.example.memberboard.entity.MemberEntity;
import com.example.memberboard.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void save(MemberDTO memberDTO) {
        if (memberDTO.getMemberProfile() == null) {
            MemberEntity.toMemberEntity(memberDTO);
        } else {
            String originalFilename = memberDTO.getMemberProfile().getOriginalFilename();
            String storedFileName = System.currentTimeMillis() + "-" + originalFilename;
            
        }
    }
}
