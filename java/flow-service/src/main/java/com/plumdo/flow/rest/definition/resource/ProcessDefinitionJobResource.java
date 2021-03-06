package com.plumdo.flow.rest.definition.resource;

import java.util.List;

import org.flowable.job.api.Job;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * 流程定义工作接口
 *
 * @author wengwh
 * @date 2018/12/6
 */
@RestController
public class ProcessDefinitionJobResource extends BaseProcessDefinitionResource {

    @GetMapping(value = "/process-definitions/{processDefinitionId}/jobs", name = "获取流程定义定时任务")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Job> activateProcessDefinition(@PathVariable String processDefinitionId) {
        return managementService.createTimerJobQuery().processDefinitionId(processDefinitionId).list();
    }

    @DeleteMapping(value = "/process-definitions/{processDefinitionId}/jobs/{jobId}", name = "删除流程定义定时任务")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteJob(@PathVariable String processDefinitionId, @PathVariable String jobId) {
        managementService.deleteTimerJob(jobId);
    }
}
