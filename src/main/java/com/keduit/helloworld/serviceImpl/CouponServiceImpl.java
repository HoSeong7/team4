package com.keduit.helloworld.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.keduit.helloworld.dto.CouponDTO;
import com.keduit.helloworld.entity.Coupon;
import com.keduit.helloworld.repository.CouponRepository;
import com.keduit.helloworld.service.CouponService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class CouponServiceImpl implements CouponService{
	
	private final CouponRepository couponRepository;

	@Override
	/** 쿠폰 번호 등록 */
	public Long register(CouponDTO dto) {
		Coupon entity = DtoToEntity(dto);
		
		couponRepository.save(entity);
		return entity.getCouponNum();
	}

	@Override
	/** 전체 쿠폰 읽어오기 */
	public List<Coupon> read() {
		
		List<Coupon> result = couponRepository.findAll();
		
		return result;
	}

	@Override
	/** 쿠폰 삭제 */
	public void remove(Integer couponNum) {

		couponRepository.deleteById(couponNum);
	}
	
	

}
