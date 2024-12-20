package com.milvus.vector_spring.invite;

import com.milvus.vector_spring.project.Project;
import com.milvus.vector_spring.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InviteRepository extends JpaRepository<Invite, Long> {
    Optional<Invite> findByProjectAndReceivedEmail(Project project, String receivedEmail);
    Optional<List<Invite>> findByReceivedEmail(String receivedEmail);
    Optional<List<Invite>> findByProject(Project project);
    Optional<List<Invite>> findByCreatedByAndProject(User createdBy, Project project);
}
