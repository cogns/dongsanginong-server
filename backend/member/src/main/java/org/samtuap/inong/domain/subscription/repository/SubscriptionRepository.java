package org.samtuap.inong.domain.subscription.repository;

import org.samtuap.inong.common.exception.BaseCustomException;
import org.samtuap.inong.domain.subscription.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import static org.samtuap.inong.common.exceptionType.SubscriptionExceptionType.SUBSCRIPTION_NOT_FOUND;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    Optional<Subscription> findByMemberId(Long memberId);

    default Subscription findByMemberIdOrThrow(Long memberId){
        return findByMemberId(memberId).orElseThrow(()->new BaseCustomException(SUBSCRIPTION_NOT_FOUND));
    }
}
