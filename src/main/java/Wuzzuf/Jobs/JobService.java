package Wuzzuf.Jobs;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@RestController
public class JobService {
    List<String>company_list;
    public JobService(List<String>company_list){
        this.company_list=company_list;
    }

    DAO job=new DAO();
    @GET
    @GetMapping("/CompanyJobs")
    @Produces(MediaType.TEXT_PLAIN)
    public LinkedHashMap<String,Long> getJobs(){
        LinkedHashMap<String,Long>jobs=job.count_jobs(main.company_jobs);
        return jobs;
    }
    @GET
    @GetMapping("/Areas")
    @Produces(MediaType.TEXT_PLAIN)
    public Map<String,Long> getAreas(){
        Map<String, Long> areas=job.counting_areas(main.areas);
        return areas;
    }
    @GET
    @GetMapping("/Skills")
    @Produces(MediaType.TEXT_PLAIN)
    public Map<String,Long> getSkill(){
        Map<String, Long> skills=job.counting_areas(main.job_skills);
        return skills;
    }
    @GET
    @GetMapping("/JobTitles")
    @Produces(MediaType.TEXT_PLAIN)
    public Map<String,Long> getTitle(){
        Map<String, Long> titles=job.counting_areas(main.job_titles);
        return titles;
    }

}