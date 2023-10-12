package com.example.memberboard.service;

import com.example.memberboard.dto.MemberDTO;
import com.example.memberboard.entity.MemberEntity;
import com.example.memberboard.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void save(MemberDTO memberDTO) throws IOException {
        System.out.println(memberDTO.toString());
        if (memberDTO.getMemberProfile().getOriginalFilename() == null) {
            MemberEntity.toMemberEntity(memberDTO);

        } else {
            String originalFilename = memberDTO.getMemberProfile().getOriginalFilename();
            String storedFileName = System.currentTimeMillis() + "-" + originalFilename;

            memberDTO.setOriginalFileName(originalFilename);
            memberDTO.setStoredFileName(storedFileName);

            MemberEntity memberEntity = MemberEntity.toMemberPlusFileEntity(memberDTO);

            String savePath = "D:\\memberProFile_img\\" + storedFileName;
            memberDTO.getMemberProfile().transferTo(new File(savePath));
            memberRepository.save(memberEntity);
        }
    }

    public boolean findByEmail(String email) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findByMemberEmail(email);
        System.out.println(optionalMemberEntity);
        if (optionalMemberEntity.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}

