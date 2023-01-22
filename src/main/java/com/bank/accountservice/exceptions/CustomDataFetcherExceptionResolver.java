package com.bank.accountservice.exceptions;

import java.util.List;

import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import graphql.schema.DataFetchingEnvironment;


@Component
public class CustomDataFetcherExceptionResolver extends DataFetcherExceptionResolverAdapter {

	@Override
	public void setThreadLocalContextAware(boolean threadLocalContextAware) {
		// TODO Auto-generated method stub
		super.setThreadLocalContextAware(threadLocalContextAware);
	}

	@Override
	public boolean isThreadLocalContextAware() {
		// TODO Auto-generated method stub
		return super.isThreadLocalContextAware();
	}

	@Override
	protected List<GraphQLError> resolveToMultipleErrors(Throwable ex, DataFetchingEnvironment env) {
		// TODO Auto-generated method stub
		return super.resolveToMultipleErrors(ex, env);
	}

	@Override
	protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
		// TODO Auto-generated method stub
//		return super.resolveToSingleError(ex, env);
		
		return new GraphQLError () {

			private static final long serialVersionUID = 1L;

			@Override
			public String getMessage() {
				// TODO Auto-generated method stub
				return ex.getMessage();
			}

			@Override
			public List<SourceLocation> getLocations() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ErrorClassification getErrorType() {
				// TODO Auto-generated method stub
				return null;
			}
			
		};
	}

	
	
}
