package repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.uscs.movies.MovieService.entity.Theater;
import com.uscs.movies.MovieService.entity.impl.AddressImpl;
import com.uscs.movies.MovieService.entity.impl.TheaterImpl;
import com.uscs.movies.MovieService.repository.TheaterRepository;

@ContextConfiguration(locations = { "classpath:spring-context.xml" })

public class TestTheaterRepository  extends AbstractTransactionalJUnit4SpringContextTests{
	@Autowired
	private TheaterRepository thRepository;

	@Test
	@Rollback(false)
	public void theaterTest() {
		TheaterImpl newTheater = new TheaterImpl();
		AddressImpl thAddress = new AddressImpl();	
		
		// add theater address
		thAddress.setStreet("12 greek blvd");
		thAddress.setCity("chicago");
		thAddress.setState("chicago");
		thAddress.setZip(90001);
		newTheater.setAddress(thAddress);
		
		int addedZipcode=thAddress.getZip();
		String addedState=thAddress.getState();
		
		// add theater details
		newTheater.setTheaterName("chicago cinemark");
		int id=thRepository.addTheater(newTheater);
		System.out.println("added theater :"+id);
		
		//get theater
		Theater found=thRepository.getTheater(id);
		Assert.assertEquals(found.getAddress().getZip(), addedZipcode);
		Assert.assertEquals(found.getAddress().getState(), addedState);
		
		
		//list theaters by zipcode
		List<Theater> theaterListByZipcode=thRepository.getTheaterByZipcode(found.getAddress().getZip());
		   for(int i = 0; i < theaterListByZipcode.size(); i++) {
	            System.out.println(theaterListByZipcode.get(i).getTheaterName());
	        }
		
		// list theaters by state
		
		List<Theater> theaterListByState=thRepository.getTheaterByCity(found.getAddress().getCity());
		 for(int i = 0; i < theaterListByState.size(); i++) {
	            System.out.println(theaterListByState.get(i).getTheaterName());
	        }
		
		// update Theater
		thAddress.setZip(90909);
		newTheater.setTheaterName("century20 pacifics");
		newTheater.setAddress(thAddress);
		thRepository.updateTheater(found);
		
		// delete Theater
		thRepository.deleteTheater(found);
		
	}

}
