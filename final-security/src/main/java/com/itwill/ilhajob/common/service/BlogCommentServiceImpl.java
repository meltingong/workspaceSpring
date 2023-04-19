package com.itwill.ilhajob.common.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.ilhajob.common.dto.BlogCommentDto;
import com.itwill.ilhajob.common.entity.BlogComment;
import com.itwill.ilhajob.common.repository.BlogCommentRepository;
import com.itwill.ilhajob.user.dto.ReviewDto;
import com.itwill.ilhajob.user.entity.Review;



@Service
public class BlogCommentServiceImpl implements BlogCommentService{
	
	private final BlogCommentRepository blogCommentRepository;
	private final ModelMapper modelMapper;
	
	@Autowired
	public BlogCommentServiceImpl(BlogCommentRepository blogCommentRepository, ModelMapper modelMapper) {
		this.blogCommentRepository = blogCommentRepository;
		this.modelMapper = modelMapper;
	}
	
	@Override
	@Transactional
	public BlogCommentDto findBlogComment(long id) throws Exception {
		Optional<BlogComment> optionalBlogComment = blogCommentRepository.findById(id);
		BlogComment findBlogComment = optionalBlogComment.get();
		return modelMapper.map(findBlogComment, BlogCommentDto.class);
	}
	
	@Override
	public List<BlogCommentDto> selectAll(){
		List<BlogComment> blogCommentList = blogCommentRepository.findAll();
		return blogCommentList.stream().map(blogComment -> modelMapper.map(blogComment, BlogCommentDto.class))
				.collect(Collectors.toList());
	}
	
	
	@Override
	public List<BlogCommentDto> findByBlogComment(Long blogId) {
		List<BlogComment> commentList = blogCommentRepository.findByBlogId(blogId);
		List<BlogCommentDto> commentDto = commentList.stream()
												.map(blogComment -> modelMapper.map(blogComment, BlogCommentDto.class))
												.collect(Collectors.toList());
				return commentDto;
	}
	
	
	@Override
	public BlogCommentDto insertBlogComment(BlogCommentDto blogCommentDto) throws Exception {
		BlogComment blogComment = modelMapper.map(blogCommentDto,BlogComment.class);
		blogComment = blogCommentRepository.save(blogComment);
		return modelMapper.map(blogComment,BlogCommentDto.class);
	}
	

/*	@Override
	public BlogCommentDto insertBlogComment(BlogCommentDto blogCommentDto) throws Exception {
		BlogComment blogComment = modelMapper.map(blogCommentDto,BlogComment.class);
		blogComment = blogCommentRepository.save(blogComment);
		return modelMapper.map(blogComment,BlogCommentDto.class);
	}*/
	
}



