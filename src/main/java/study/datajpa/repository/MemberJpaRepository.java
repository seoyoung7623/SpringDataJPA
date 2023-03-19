package study.datajpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import study.datajpa.entity.Member;

import java.util.List;
import java.util.Optional;

@Repository
public class MemberJpaRepository {
    @PersistenceContext
    private EntityManager em;

    public Member save(Member member){
        em.persist(member);
        return member;
    }

    public void delete(Member member){
        em.remove(member);

    }

    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
        //전체조회, 특정 조건 query 조회 여기서 member는 entity/ Member.class는 반환타입
    }

    public Optional<Member> findById(Long id){
        Member member = em.find(Member.class,id);
        return Optional.ofNullable(member); //널일수도 있다.
    }

    public long count(){
        return em.createQuery("select count(m) from Member m",Long.class)
                .getSingleResult();//count는 long으로 반환

    }

    public Member find(Long id){
        return em.find(Member.class,id); //하나 조회
    }
}


