import * as React from 'react';

import { CommitsHistory } from 'core/features/repository/commitsHistory';
import { IRepository } from 'core/shared/models/Repository/Repository';
import { PageCard } from 'core/shared/view/elements/PageComponents';

import RepositoryDetailsPagesLayout from '../shared/RepositoryDetailsPagesLayout/RepositoryDetailsPagesLayout';

interface ILocalProps {
  repository: IRepository;
}

const CommitsHistoryPage = ({ repository }: ILocalProps) => {
  return (
    <RepositoryDetailsPagesLayout repository={repository}>
      <PageCard>
        <CommitsHistory repository={repository} />
      </PageCard>
    </RepositoryDetailsPagesLayout>
  );
};

export default CommitsHistoryPage;