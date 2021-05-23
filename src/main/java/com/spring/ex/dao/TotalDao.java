package com.spring.ex.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.ex.dto.BasketDto;
import com.spring.ex.dto.BoardDTO;
import com.spring.ex.dto.JumunDto;
import com.spring.ex.dto.MemberDto;
import com.spring.ex.dto.ProductDto;
import com.spring.ex.dto.RefundDto;
import com.spring.ex.dto.SellDto;

@Repository
public class TotalDao implements MemberDao{
	@Inject
	private SqlSession sqlSessionTemplate;
	private static final String namespace = "com.spring.ex.mapper";//mapper �� id �� ã�°�
	
	// 회원정보 select문
	@Override
	public List<MemberDto> memberList() throws Exception {
		return sqlSessionTemplate.selectList(namespace+".id");
	}
	
	// 회원가입 insert문
	@Override
	public void register(MemberDto dto) throws Exception {
		sqlSessionTemplate.insert(namespace + ".register", dto);
	}
	
	//회원 정보 update문 수정 
	@Override
	public void MemberUpdate(MemberDto Mdto) throws Exception {
		sqlSessionTemplate.update(namespace + ".MemberUpdate", Mdto);
	}
	
	// 로그인
	@Override
	public MemberDto login(MemberDto ldto) throws Exception{
		return sqlSessionTemplate.selectOne(namespace + ".login", ldto);
	}
	
	// 회원상세
	@Override
	public MemberDto memberDetail(MemberDto mddto) throws Exception{
		return sqlSessionTemplate.selectOne(namespace + ".memberDetail", mddto);
	}
	
	// 회원탈퇴
	@Override
	public void memberdelete(MemberDto ddto) throws Exception {
		sqlSessionTemplate.delete(namespace + ".memberdelete", ddto);
		
	}
	
	// 상품정보 select문
	@Override
	public List<ProductDto> productList() throws Exception {
		return sqlSessionTemplate.selectList(namespace+".product");
	}
	
	// 상품상세 select문
	@Override
	public ProductDto product(ProductDto pdto) throws Exception {
		return sqlSessionTemplate.selectOne(namespace + ".product2", pdto); 
	}
	
	//상품수정
	@Override
	public void ProductUpdate(ProductDto pudto) throws Exception{
		sqlSessionTemplate.update(namespace + ".productUpdate", pudto);
	}
	
	// 헬스기구랭킹 select문
	@Override
	public List<ProductDto> healthRanking() throws Exception {
		return sqlSessionTemplate.selectList(namespace+".health");
	}
	
	// 요가상품랭킹 select문
	@Override
	public List<ProductDto> yogaRanking() throws Exception {
		return sqlSessionTemplate.selectList(namespace+".yoga");
	}
	
	// 운동식품랭킹 select문
	@Override
	public List<ProductDto> foodRanking() throws Exception {
		return sqlSessionTemplate.selectList(namespace+".food");
	}
	
	// 남성상품랭킹 select문
	@Override
	public List<ProductDto> manRanking() throws Exception {
		return sqlSessionTemplate.selectList(namespace+".man");
	}
	
	// 여성상품랭킹 select문
	@Override
	public List<ProductDto> womanRanking() throws Exception {
		return sqlSessionTemplate.selectList(namespace+".woman");
	}
	
	// 주문내역 select문
	@Override
	public List<JumunDto> jumunList() throws Exception {
		return sqlSessionTemplate.selectList(namespace+".jumun");
	}
	
	// 장바구니 select문
	@Override
	public List<BasketDto> basketList() throws Exception {
		return sqlSessionTemplate.selectList(namespace+".basket");
	}

	// 고객문의 게시판 목록 select문
	@Override
	public List<BoardDTO> boardList() throws Exception{
		return sqlSessionTemplate.selectList(namespace+".board");
	}
	
	// 고객문의 게시판 글쓰기 insert문
	@Override
	public void board(BoardDTO bdto) throws Exception {
		sqlSessionTemplate.insert(namespace + ".boardWrite", bdto);
	}
	
	// 환불요청 게시판 목록 select문
	@Override
	public List<RefundDto> refundList() throws Exception{
		return sqlSessionTemplate.selectList(namespace+".refund");
	}
	
	// 판매상품목록 select문
	@Override
	public List<SellDto> sellList() throws Exception{
		return sqlSessionTemplate.selectList(namespace+".sell");
	}
}
