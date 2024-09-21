package org.samtuap.inong.domain.seller.dto;

import lombok.Builder;
import org.samtuap.inong.domain.farm.entity.Farm;
import org.samtuap.inong.domain.farm.entity.FarmCategory;
import org.samtuap.inong.domain.seller.entity.Seller;

@Builder
public record SellerInfoResponse(
        String name,
        String email,
        String businessName,
        String farmName,
        String farmIntro,
        String categoryTitle
) {
    public static SellerInfoResponse fromEntity(Seller seller, Farm farm, FarmCategory category) {
        return SellerInfoResponse.builder()
                .name(seller.getName())
                .email(seller.getEmail())
                .businessName(seller.getBusinessName())
                .farmName(farm.getFarmName())
                .farmIntro(farm.getFarmIntro())
                .categoryTitle(category.getTitle())
                .build();
    }
}
