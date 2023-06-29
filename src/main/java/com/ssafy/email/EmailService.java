package com.ssafy.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailService {

    private JavaMailSender javaMailSender;


    @Async
    public void sendEmail(SimpleMailMessage email) {
        javaMailSender.send(email);
    }
    
    public void send(String to, String subject, String message) {
        // 보낸 사람, 받는 사람, 참조, 제목 및 텍스트를 포함하는 메시지를 만든다
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("wanderlustify9@gmail.com");
        mailMessage.setTo(to); //받는 사람 주소
        mailMessage.setSubject(subject); //제목
        mailMessage.setText(message); //메시지 내용
        javaMailSender.send(mailMessage); //메일 발송
    }
}