package org.samtuap.inong.domain.discount.api;

import lombok.RequiredArgsConstructor;
import org.samtuap.inong.domain.discount.dto.DiscountCreateRequest;
import org.samtuap.inong.domain.discount.dto.DiscountResponse;
import org.samtuap.inong.domain.discount.dto.DiscountUpdateRequest;
import org.samtuap.inong.domain.discount.service.DiscountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/discounts")
@RequiredArgsConstructor
public class DiscountController {

    private final DiscountService discountService;

    // 할인 생성
    @PostMapping("/{packageProductId}/create")
    public ResponseEntity<DiscountResponse> createDiscount(
            @PathVariable Long packageProductId,
            @RequestBody DiscountCreateRequest request) {
        DiscountResponse createdDiscount = discountService.createDiscount(packageProductId, request);
        return ResponseEntity.ok(createdDiscount);
    }

    // 할인 수정
    @PutMapping("/{discountId}/update")
    public ResponseEntity<DiscountResponse> updateDiscount(
            @PathVariable Long discountId,
            @RequestBody DiscountUpdateRequest request) {
        DiscountResponse updatedDiscount = discountService.updateDiscount(discountId, request);
        return ResponseEntity.ok(updatedDiscount);
    }

    // 할인 삭제
    @DeleteMapping("/{discountId}/delete")
    public ResponseEntity<Void> deleteDiscount(@PathVariable Long discountId) {
        discountService.deleteDiscount(discountId);
        return ResponseEntity.noContent().build();
    }
}
