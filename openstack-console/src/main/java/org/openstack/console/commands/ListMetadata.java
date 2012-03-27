package org.openstack.console.commands;

import java.util.HashMap;

import org.kohsuke.args4j.Argument;
import org.openstack.api.compute.TenantResource;
import org.openstack.console.model.InstanceName;
import org.openstack.model.compute.Server;

public class ListMetadata extends OpenstackCliCommandRunnerBase {
	@Argument(index = 0)
	public InstanceName instanceName;

	public ListMetadata() {
		super("list", "instancemetadata");
	}

	@Override
	public Object runCommand() throws Exception {
		TenantResource compute = getContext().getComputeClient();

		String instanceId = instanceName.findInstanceId(getContext());

		Server server = compute.servers().server(instanceId).get();
		return server.getMetadata().getItems();
	}

}