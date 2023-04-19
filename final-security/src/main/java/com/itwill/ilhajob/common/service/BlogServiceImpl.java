package com.itwill.ilhajob.common.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.ilhajob.common.dto.BlogDto;
import com.itwill.ilhajob.common.entity.Blog;
import com.itwill.ilhajob.common.repository.BlogRepository;


@Service
public class BlogServiceImpl implements BlogService {
	
	private final BlogRepository blogRepository;
	private final ModelMapper modelMapper;
	
	@Autowired
	public BlogServiceImpl(BlogRepository blogRepository, ModelMapper modelMapper) {
		this.blogRepository = blogRepository;
		this.modelMapper = modelMapper;
	}
	
	@Override
	public BlogDto insertBlog(BlogDto blogDto) throws Exception {
        Blog blog = modelMapper.map(blogDto, Blog.class);
        blog = blogRepository.save(blog);
        return modelMapper.map(blog, BlogDto.class);
	}
	

	@Override
	public BlogDto updateBlog(Long id,BlogDto blogDto) throws Exception {
		Blog blog = blogRepository.findById(id).orElseThrow(null);
		blogDto.setBlogTitle(blog.getBlogTitle());
		blogDto.setBlogImage(blog.getBlogImage());
		blogDto.setBlogContent(blog.getBlogContent());
		blog = blogRepository.save(blog);
		return modelMapper.map(blog, BlogDto.class);
	}

	
	@Override
	public void deleteBlog(Long id) throws Exception {
		blogRepository.deleteById(id);
	}
	
	@Override
	public List<BlogDto> selectAll(){
		List<Blog> blogList = blogRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
		return blogList.stream().map(blog -> modelMapper.map(blog, BlogDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public BlogDto findBlog(Long id) throws Exception {
		Optional<Blog> optionalBlog = blogRepository.findById(id);
		Blog findBlog = optionalBlog.get();
		return modelMapper.map(findBlog, BlogDto.class);
	}
	
	 @Override
	    public Page<BlogDto> findAll(Pageable pageable) {
		Page<Blog> blogList = blogRepository.findAll(pageable);
		return blogList.map(blog -> modelMapper.map(blog, BlogDto.class)); 
	 }
	/*
	 * 	@Override
	@Transactional
	public CorpDto findCorp(String corpLoginId) throws Exception {
		Optional<Corp> optionalCorp = corpRepository.findByCorpLoginId(corpLoginId);
		Corp findCorp = optionalCorp.get();
		return modelMapper.map(findCorp, CorpDto.class);
	}
	 */


	@Override
	@Transactional
	public int updateViews(Long id) {
		 return blogRepository.updateViews(id);
	
		
}	
	
	/*
		return modelMapper.map(blog, BlogDto.class);
		 * <update id="updateBlogReadCount" parameterType="int">
		update blog set blog_read_count = blog_read_count+1 where blog_seq=#{blogSeq}
	</update>
    
	}
		 */
		
	/*
	@Override
	public int updateBlogLikeCount(int blogSeq) {

		return 0;
	}
	
	
	@Override
	public int updateBlogLikeDiscount(int blogSeq) {
	
		return 0;
	}
	 */


	
	
}
