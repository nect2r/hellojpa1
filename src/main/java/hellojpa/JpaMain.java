package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            //비영속
            Member member = new Member();
            member.setId(100L);
            member.setName("HelloJPA");

            //영속 -> 영속성 컨텍스트에서 관리
            System.out.println("=== BEFORE ===");
            em.persist(member);
            System.out.println("=== AFTER ===");

            //영속성 컨테스트에 들어있는 멤버 객체를 컨텍스트에서 분리 , 준영속 상태
            em.detach(member);

            //실제 DB의 객체를 삭제하는상태태
           em.remove(member);

            //커밋시 -> 영속성 컨텍스트에서 관리중인 객체를 DB로 이동
            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
